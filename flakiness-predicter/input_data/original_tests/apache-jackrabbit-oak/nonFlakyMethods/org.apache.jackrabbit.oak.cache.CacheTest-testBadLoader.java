@Test public void testBadLoader(){
  CacheLIRS<Integer,String> cache=createCache(10,1);
  try {
    cache.get(1,new Callable<String>(){
      @Override public String call() throws Exception {
        return null;
      }
    }
);
    fail();
  }
 catch (  Exception e) {
  }
}
