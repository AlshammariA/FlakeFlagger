@Test public void testRefresh() throws ExecutionException {
  CacheLIRS<Integer,String> cache=new CacheLIRS.Builder().maximumWeight(100).weigher(new Weigher<Integer,String>(){
    @Override public int weigh(    Integer key,    String value){
      return key + value.length();
    }
  }
).build(new CacheLoader<Integer,String>(){
    @Override public String load(    Integer key) throws Exception {
      if (key < 0 || key >= 100) {
        throw new Exception("Out of range");
      }
      return "n" + key;
    }
    @Override public ListenableFuture<String> reload(    Integer key,    String oldValue){
      assertTrue(oldValue != null);
      SettableFuture<String> f=SettableFuture.create();
      f.set(oldValue);
      return f;
    }
  }
);
  assertEquals("n1",cache.get(1));
  cache.refresh(1);
  cache.refresh(2);
  try {
    cache.get(-1);
    fail();
  }
 catch (  Exception e) {
  }
  cache.refresh(-1);
}
