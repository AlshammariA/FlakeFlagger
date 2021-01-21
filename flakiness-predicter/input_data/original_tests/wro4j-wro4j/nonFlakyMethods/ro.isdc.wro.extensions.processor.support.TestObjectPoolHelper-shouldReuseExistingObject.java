@Test public void shouldReuseExistingObject() throws Exception {
  final ObjectPoolHelper<Integer> pool=new ObjectPoolHelper<Integer>(new ObjectFactory<Integer>(){
    @Override public Integer create(){
      return 3;
    }
  }
);
  final Integer object=pool.getObject();
  Assert.assertEquals(Integer.valueOf(3),object);
  pool.returnObject(object);
}
