@Test public void observation() throws RepositoryException, InterruptedException, ExecutionException {
  final MyListener listener=new MyListener();
  observationManager.addEventListener(listener,ALL_EVENTS,"/",true,null,null,false);
  try {
    Node n=getAdminSession().getNode(TEST_PATH);
    for (int i=0; i < 1000; i++) {
      n.addNode("n" + i);
      n.getSession().save();
    }
    listener.waitFor(CONDITION_TIMEOUT,new Condition(){
      @Override public boolean evaluate(){
        return listener.numAdded == 1000;
      }
    }
);
    assertEquals("",listener.error);
    assertEquals("added nodes",1000,listener.numAdded);
    for (int i=0; i < 1000; i++) {
      n.getNode("n" + i).remove();
      n.getSession().save();
    }
    listener.waitFor(CONDITION_TIMEOUT,new Condition(){
      @Override public boolean evaluate(){
        return listener.numRemoved == 1000;
      }
    }
);
    assertEquals("",listener.error);
    assertEquals("removed nodes",1000,listener.numRemoved);
    for (int i=0; i < 100; i++) {
      n.setProperty("test" + i,"foo");
      n.getSession().save();
    }
    listener.waitFor(CONDITION_TIMEOUT,new Condition(){
      @Override public boolean evaluate(){
        return listener.numPropsAdded == 1100;
      }
    }
);
    assertEquals("",listener.error);
    assertEquals("properties added",1100,listener.numPropsAdded);
    for (int i=0; i < 100; i++) {
      n.setProperty("test" + i,i);
      n.getSession().save();
    }
    listener.waitFor(CONDITION_TIMEOUT,new Condition(){
      @Override public boolean evaluate(){
        return listener.numPropsModified == 100;
      }
    }
);
    assertEquals("",listener.error);
    assertEquals("properties modified",100,listener.numPropsModified);
    for (int i=0; i < 10; i++) {
      n.setProperty("test100","foo");
      n.getSession().save();
      assertTrue("Gave up waiting for events",listener.waitFor(CONDITION_TIMEOUT,new Condition(){
        @Override public boolean evaluate(){
          return listener.test100Exists;
        }
      }
));
      n.getProperty("test100").remove();
      n.getSession().save();
      assertTrue("Gave up waiting for events",listener.waitFor(CONDITION_TIMEOUT,new Condition(){
        @Override public boolean evaluate(){
          return !listener.test100Exists;
        }
      }
));
    }
    assertEquals("",listener.error);
    for (int i=0; i < 100; i++) {
      n.getProperty("test" + i).remove();
      n.getSession().save();
    }
    listener.waitFor(CONDITION_TIMEOUT,new Condition(){
      @Override public boolean evaluate(){
        return listener.numPropsRemoved == 1100;
      }
    }
);
    assertEquals("",listener.error);
    assertEquals("properties removed",1100,listener.numPropsRemoved);
  }
  finally {
    observationManager.removeEventListener(listener);
  }
}
