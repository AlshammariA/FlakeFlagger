private void cascadingSplit(String path){
  mk.dispose();
  mk=new DocumentMK.Builder().setAsyncDelay(0).open();
  DocumentStore store=mk.getDocumentStore();
  DocumentNodeStore ns=mk.getNodeStore();
  String rev=null;
  String p="/";
  for (  String name : PathUtils.elements(path)) {
    rev=mk.commit(p,"+\"" + name + "\":{}",rev,null);
    p=PathUtils.concat(p,name);
  }
  List<String> revs=Lists.newArrayList();
  for (int i=0; i < NodeDocument.PREV_SPLIT_FACTOR + 1; i++) {
    NodeDocument doc=store.find(NODES,Utils.getIdFromPath(path));
    assertNotNull(doc);
    assertEquals(i,doc.getPreviousRanges().size());
    for (int j=0; j < NodeDocument.NUM_REVS_THRESHOLD; j++) {
      int value=(i * NodeDocument.NUM_REVS_THRESHOLD + j);
      rev=mk.commit(path,"^\"prop\":" + value,rev,null);
      revs.add(rev);
    }
    ns.runBackgroundOperations();
  }
  NodeDocument doc=store.find(NODES,Utils.getIdFromPath(path));
  assertNotNull(doc);
  assertEquals(2,doc.getPreviousRanges().size());
  List<NodeDocument> prevDocs=ImmutableList.copyOf(doc.getAllPreviousDocs());
  assertEquals(1 + 11,prevDocs.size());
  assertTrue(Iterables.any(prevDocs,new Predicate<NodeDocument>(){
    @Override public boolean apply(    NodeDocument input){
      return input.getSplitDocType() == SplitDocType.INTERMEDIATE;
    }
  }
));
  for (  String s : revs) {
    Revision r=Revision.fromString(s);
    if (doc.getLocalRevisions().containsKey(r)) {
      continue;
    }
    Iterable<NodeDocument> prev=doc.getPreviousDocs("prop",r);
    assertEquals(1,Iterables.size(prev));
    for (    NodeDocument d : prev) {
      assertTrue(d.containsRevision(r));
    }
  }
  int numPrev=0;
  for (  NodeDocument prev : doc.getPreviousDocs("prop",null)) {
    numPrev++;
    assertTrue(!prev.getValueMap("prop").isEmpty());
  }
  assertEquals(2,numPrev);
  Revision previous=null;
  int numValues=0;
  Map<Revision,String> valueMap=doc.getValueMap("prop");
  for (  Map.Entry<Revision,String> entry : valueMap.entrySet()) {
    if (previous != null) {
      assertTrue(ns.isRevisionNewer(previous,entry.getKey()));
    }
    previous=entry.getKey();
    numValues++;
    assertEquals(entry.getValue(),valueMap.get(entry.getKey()));
  }
  assertEquals(revs.size(),numValues);
  assertEquals(revs.size(),valueMap.size());
  assertNotNull(doc.getNodeAtRevision(ns,Revision.fromString(rev),null));
}
