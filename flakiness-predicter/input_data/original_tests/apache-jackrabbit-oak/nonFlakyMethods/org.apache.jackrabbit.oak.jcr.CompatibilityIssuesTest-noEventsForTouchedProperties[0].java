/** 
 * OAK-948 - JR2 generates propertyChange event for touched properties while Oak does not
 */
@Test public void noEventsForTouchedProperties() throws RepositoryException, InterruptedException {
  final String testNodeName="test_touched_node";
  final String testNodePath='/' + testNodeName;
  Session session=getAdminSession();
  Node testNode=session.getRootNode().addNode(testNodeName);
  testNode.setProperty("foo","bar");
  testNode.setProperty("foo2","bar0");
  session.save();
  Session observingSession=createAdminSession();
  ObservationManager observationManager=observingSession.getWorkspace().getObservationManager();
  try {
    final List<Event> events=new ArrayList<Event>();
    final CountDownLatch latch=new CountDownLatch(1);
    EventListener listener=new EventListener(){
      @Override public void onEvent(      EventIterator eventIt){
        while (eventIt.hasNext()) {
          events.add(eventIt.nextEvent());
        }
        if (!events.isEmpty()) {
          latch.countDown();
        }
      }
    }
;
    observationManager.addEventListener(listener,PROPERTY_CHANGED,testNodePath,true,null,null,false);
    session.getNode(testNodePath).setProperty("foo","bar");
    session.getNode(testNodePath).setProperty("foo2","bar2");
    session.save();
    latch.await(60,TimeUnit.SECONDS);
    assertEquals(1,events.size());
  }
  finally {
    observingSession.logout();
  }
}
