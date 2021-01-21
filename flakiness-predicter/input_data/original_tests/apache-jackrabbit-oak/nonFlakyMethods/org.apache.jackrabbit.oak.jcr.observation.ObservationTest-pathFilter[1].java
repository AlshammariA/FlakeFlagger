@Test public void pathFilter() throws Exception {
  final String path="/events/only/here";
  for (  boolean deep : new boolean[]{false,true}) {
    Node root=getNode("/");
    if (root.hasNode("events")) {
      root.getNode("events").remove();
      root.getSession().save();
    }
    ExpectationListener listener=new ExpectationListener();
    observationManager.addEventListener(listener,NODE_ADDED,path,deep,null,null,false);
    try {
      root.addNode("events").addNode("only").addNode("here").addNode("below").addNode("this");
      listener.expect("/events/only/here/below",NODE_ADDED);
      if (deep) {
        listener.expect("/events/only/here/below/this",NODE_ADDED);
      }
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
}
