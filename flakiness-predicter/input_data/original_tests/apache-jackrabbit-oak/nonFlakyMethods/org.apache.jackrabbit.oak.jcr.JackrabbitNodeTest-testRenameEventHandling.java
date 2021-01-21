public void testRenameEventHandling() throws RepositoryException {
  Session s=getHelper().getSuperuserSession();
  ObservationManager mgr=s.getWorkspace().getObservationManager();
  EventResult result=new EventResult(log);
  try {
    mgr.addEventListener(result,Event.PERSIST | Event.NODE_ADDED | Event.NODE_MOVED| Event.NODE_REMOVED,testRootNode.getPath(),true,null,null,false);
    NodeIterator it=testRootNode.getNodes();
    Node n=it.nextNode();
    String name=n.getName();
    JackrabbitNode node=(JackrabbitNode)n;
    node.rename(name + 'X');
    superuser.save();
    boolean foundMove=false;
    StringBuffer diags=new StringBuffer();
    for (    Event event : result.getEvents(5000)) {
      if (diags.length() != 0) {
        diags.append(", ");
      }
      diags.append("type " + event.getType() + " "+ event.getDate()+ "ms "+ event.getPath());
      if (Event.NODE_MOVED == event.getType()) {
        foundMove=true;
        break;
      }
    }
    if (diags.length() == 0) {
      diags.append("none");
    }
    if (!foundMove) {
      testRootNode.addNode(name + "XYZ");
      superuser.save();
      StringBuffer addDiags=new StringBuffer();
      for (      Event event : result.getEvents(60000)) {
        if (addDiags.length() != 0) {
          addDiags.append(", ");
        }
        addDiags.append("type " + event.getType() + " "+ event.getDate()+ "ms "+ event.getPath());
      }
      if (addDiags.length() > 0) {
        diags.append("; next event after additional addNode/save operation: " + addDiags);
      }
    }
    if (!foundMove) {
      fail("Expected NODE_MOVED event upon renaming a node (received: " + diags + ")");
    }
  }
  finally {
    mgr.removeEventListener(result);
    s.logout();
  }
}
