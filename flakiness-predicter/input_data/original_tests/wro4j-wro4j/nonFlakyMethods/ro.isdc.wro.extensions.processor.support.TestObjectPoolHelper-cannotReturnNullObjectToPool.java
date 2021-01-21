@Test(expected=NullPointerException.class) public void cannotReturnNullObjectToPool() throws Exception {
  final ObjectPoolHelper<Integer> pool=new ObjectPoolHelper<Integer>(new ObjectFactory<Integer>(){
    @Override public Integer create(){
      return null;
    }
  }
);
  final Integer object=pool.getObject();
  pool.returnObject(object);
}
