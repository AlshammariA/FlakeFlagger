@Test public void test() throws Exception {
  final AtomicInteger id=new AtomicInteger();
  Concurrent.run("MicroKernel",new Concurrent.Task(){
    @Override public void call() throws Exception {
      long start=System.currentTimeMillis();
      String rev=mk.getHeadRevision();
      int i=id.getAndIncrement();
      String newRev=mk.commit("/","+\"" + i + "\":{\"x\": "+ i+ "}",rev,"");
      Assert.assertTrue(!newRev.equals(rev));
      mk.getJournal(rev,newRev,null);
      mk.getRevisionHistory(start,100,null);
      mk.getNodes("/" + i,newRev,1,0,-1,null);
      mk.getNodes("/" + i,newRev,0,0,0,null);
      Assert.assertFalse(mk.nodeExists("/" + i,rev));
      Assert.assertTrue(mk.nodeExists("/" + i,newRev));
      rev=newRev;
      newRev=mk.commit("/","-\"" + i + "\"",rev,"");
      Assert.assertTrue(mk.nodeExists("/" + i,rev));
      Assert.assertFalse(mk.nodeExists("/" + i,newRev));
    }
  }
);
}
