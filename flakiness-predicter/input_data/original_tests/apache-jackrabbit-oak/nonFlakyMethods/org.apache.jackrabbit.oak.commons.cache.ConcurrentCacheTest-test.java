@Test public void test() throws Exception {
  Concurrent.run("cache",new Concurrent.Task(){
    @Override public void call() throws Exception {
      int k=value++ % 10;
      Data v=cache.get(k);
      Assert.assertEquals(k,v.value);
    }
  }
);
}
