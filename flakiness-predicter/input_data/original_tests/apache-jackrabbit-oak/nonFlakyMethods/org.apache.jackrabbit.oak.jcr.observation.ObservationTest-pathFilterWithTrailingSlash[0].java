@Test public void pathFilterWithTrailingSlash() throws Exception {
  final String path="/events/only/here";
  ExpectationListener listener=new ExpectationListener();
  listener.expect(new Expectation(path){
    @Override public boolean onEvent(    Event event) throws Exception {
      return PathUtils.isAncestor(path,event.getPath());
    }
  }
);
  observationManager.addEventListener(listener,NODE_ADDED,path + '/',true,null,null,false);
  try {
    Node root=getNode("/");
    root.addNode("events").addNode("only").addNode("here").addNode("at");
    root.getSession().save();
    List<Expectation> missing=listener.getMissing(TIME_OUT,TimeUnit.SECONDS);
    assertTrue("Missing events: " + missing,missing.isEmpty());
    List<Event> unexpected=listener.getUnexpected();
    assertTrue("Unexpected events: " + unexpected,unexpected.isEmpty());
  }
  finally {
    observationManager.removeEventListener(listener);
  }
}
