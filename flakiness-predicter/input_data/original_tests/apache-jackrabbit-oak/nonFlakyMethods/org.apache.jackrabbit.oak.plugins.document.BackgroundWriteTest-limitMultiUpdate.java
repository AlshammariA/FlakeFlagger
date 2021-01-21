@Test public void limitMultiUpdate(){
  DocumentMK mk=new DocumentMK.Builder().setDocumentStore(new TestStore()).setAsyncDelay(0).open();
  List<String> paths=new ArrayList<String>();
  StringBuilder sb=new StringBuilder();
  for (int i=0; paths.size() < UnsavedModifications.BACKGROUND_MULTI_UPDATE_LIMIT * 2; i++) {
    String child="node-" + i;
    sb.append("+\"").append(child).append("\":{}");
    for (int j=0; j < 1000; j++) {
      String p=child + "/node-" + j;
      paths.add(p);
      sb.append("+\"").append(p).append("\":{}");
    }
  }
  mk.commit("/",sb.toString(),null,null);
  mk.runBackgroundOperations();
  Revision r=mk.getNodeStore().newRevision();
  UnsavedModifications pending=mk.getNodeStore().getPendingModifications();
  paths.add("/");
  for (  String p : paths) {
    pending.put(p,r);
  }
  mk.runBackgroundOperations();
  mk.dispose();
}
