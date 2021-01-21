@Test public void testEventGeneration() throws Exception {
  deny(path,readPrivileges);
  ObservationManager obsMgr=testSession.getWorkspace().getObservationManager();
  EventResult listener=new EventResult(this.log);
  try {
    obsMgr.addEventListener(listener,Event.NODE_REMOVED,path,true,new String[0],new String[0],true);
    superuser.getItem(childNPath).remove();
    superuser.save();
    obsMgr.removeEventListener(listener);
    Event[] evts=listener.getEvents(DEFAULT_WAIT_TIMEOUT);
    for (    Event evt : evts) {
      if (evt.getType() == Event.NODE_REMOVED && evt.getPath().equals(childNPath)) {
        fail("TestUser does not have READ permission below " + path + " -> events below must not show up.");
      }
    }
  }
  finally {
    obsMgr.removeEventListener(listener);
  }
}
