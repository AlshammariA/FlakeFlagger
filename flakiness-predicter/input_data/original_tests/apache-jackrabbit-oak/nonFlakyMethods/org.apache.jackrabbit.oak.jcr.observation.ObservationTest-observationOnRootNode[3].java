@Test public void observationOnRootNode() throws Exception {
  ExpectationListener listener=new ExpectationListener();
  observationManager.addEventListener(listener,PROPERTY_ADDED,"/",true,null,null,false);
  try {
    Node root=getNode("/");
    listener.expectAdd(root.setProperty("prop","value"));
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
