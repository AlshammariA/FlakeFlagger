@Test public void manyRevisions(){
  final int numMKs=3;
  MemoryDocumentStore ds=new MemoryDocumentStore();
  MemoryBlobStore bs=new MemoryBlobStore();
  List<Set<String>> changes=new ArrayList<Set<String>>();
  List<DocumentMK> mks=new ArrayList<DocumentMK>();
  for (int i=1; i <= numMKs; i++) {
    DocumentMK.Builder builder=new DocumentMK.Builder();
    builder.setDocumentStore(ds).setBlobStore(bs).setAsyncDelay(0);
    DocumentMK mk=builder.setClusterId(i).open();
    mks.add(mk);
    changes.add(new HashSet<String>());
    if (i == 1) {
      mk.commit("/","+\"test\":{}",null,null);
      mk.runBackgroundOperations();
    }
  }
  List<String> propNames=Arrays.asList("prop1","prop2","prop3");
  Random random=new Random(0);
  for (int i=0; i < 1000; i++) {
    int mkIdx=random.nextInt(mks.size());
    DocumentMK mk=mks.get(mkIdx);
    DocumentNodeStore ns=mk.getNodeStore();
    String name=propNames.get(random.nextInt(propNames.size()));
    for (int j=0; j < changes.size(); j++) {
      Set<String> c=changes.get(j);
      if (c.contains(name)) {
        syncMKs(mks,j);
        c.clear();
        break;
      }
    }
    NodeDocument doc=ds.find(NODES,Utils.getIdFromPath("/test"));
    assertNotNull(doc);
    Revision head=ns.getHeadRevision();
    Revision lastRev=ns.getPendingModifications().get("/test");
    DocumentNodeState n=doc.getNodeAtRevision(mk.getNodeStore(),head,lastRev);
    assertNotNull(n);
    String value=n.getPropertyAsString(name);
    if (value == null) {
      value=String.valueOf(0);
    }
 else {
      value=String.valueOf(Integer.parseInt(value) + 1);
    }
    mk.commit("/test","^\"" + name + "\":"+ value,null,null);
    changes.get(mkIdx).add(name);
  }
  for (  DocumentMK mk : mks) {
    mk.dispose();
  }
}
