@Test(expected=NullPointerException.class) public void cannotSetNullObjectPool() throws Exception {
  final ObjectPoolHelper<Integer> pool=new ObjectPoolHelper<Integer>(new ObjectFactory<Integer>(){
    @Override public Integer create(){
      return 3;
    }
  }
);
  pool.setObjectPool(null);
}
