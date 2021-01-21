@Test public void infoMap() throws RepositoryException, ExecutionException, InterruptedException {
  ExpectationListener listener=new ExpectationListener();
  observationManager.addEventListener(listener,NODE_ADDED,"/",true,null,null,false);
  try {
    Node n=getNode(TEST_PATH);
    n.addNode("n1","oak:Unstructured");
    n.addNode("n2");
    n.getNode("n2").addMixin(TEST_TYPE);
    listener.expect(new Expectation("infoMap for n1"){
      @Override public boolean onEvent(      Event event) throws Exception {
        if (event.getPath().endsWith("n1")) {
          Map<?,?> info=event.getInfo();
          return info != null && "oak:Unstructured".equals(info.get(JCR_PRIMARYTYPE));
        }
 else {
          return false;
        }
      }
    }
);
    listener.expect(new Expectation("infoMap for n2"){
      @Override public boolean onEvent(      Event event) throws Exception {
        if (event.getPath().endsWith("n2")) {
          Map<?,?> info=event.getInfo();
          if (info == null) {
            return false;
          }
          Object mixinTypes=info.get(JCR_MIXINTYPES);
          if (!(mixinTypes instanceof String[])) {
            return false;
          }
          Object primaryType=info.get(JCR_PRIMARYTYPE);
          String[] mixins=(String[])mixinTypes;
          return NT_UNSTRUCTURED.equals(primaryType) && mixins.length == 1 && TEST_TYPE.equals(mixins[0]);
        }
 else {
          return false;
        }
      }
    }
);
    getAdminSession().save();
    List<Expectation> missing=listener.getMissing(TIME_OUT,TimeUnit.SECONDS);
    assertTrue("Missing events: " + missing,missing.isEmpty());
    List<Event> unexpected=listener.getUnexpected();
    assertTrue("Unexpected events: " + unexpected,unexpected.isEmpty());
  }
  finally {
    observationManager.removeEventListener(listener);
  }
}
