@Test public void manyChildrenWithoutIndex() throws Exception {
  if (session == null) {
    return;
  }
  Node index=session.getRootNode().getNode("oak:index");
  if (index.hasNode("nodetype")) {
    index.getNode("nodetype").remove();
    session.save();
  }
  long start=System.currentTimeMillis(), last=start;
  int count=10;
  Profiler prof=null;
  String nodeType=NodeTypeConstants.NT_OAK_UNSTRUCTURED;
  if (session.getRootNode().hasNode("many")) {
    session.getRootNode().getNode("many").remove();
    session.save();
  }
  Node many=session.getRootNode().addNode("many",nodeType);
  for (int i=0; i < count; i++) {
    Node n=many.addNode("test" + i,nodeType);
    n.setProperty("prop",i);
    if (i % 100 == 0) {
      session.save();
    }
    long now=System.currentTimeMillis();
    if (now - last > 5000) {
      int opsPerSecond=(int)(i * 1000 / (now - start));
      System.out.println(i + " ops; " + opsPerSecond+ " op/s");
      last=now;
      if (prof != null) {
        System.out.println(prof.getTop(5));
      }
      if (opsPerSecond < 1000 && i % 100 == 0) {
        prof=new Profiler();
        prof.startCollecting();
      }
    }
  }
  start=System.currentTimeMillis();
  last=start;
  for (int i=0; i < count; i++) {
    Node n=many.getNode("test" + i);
    long x=n.getProperty("prop").getValue().getLong();
    assertEquals(i,x);
    long now=System.currentTimeMillis();
    if (now - last > 5000) {
      int opsPerSecond=(int)(i * 1000 / (now - start));
      System.out.println(i + " read ops; " + opsPerSecond+ " op/s");
      last=now;
      if (prof != null) {
        System.out.println(prof.getTop(5));
      }
      if (opsPerSecond < 1000 && i % 100 == 0) {
        prof=new Profiler();
        prof.startCollecting();
      }
    }
  }
}
