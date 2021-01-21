@Test public void shouldUseCustomObjectPool() throws Exception {
  final ObjectPoolHelper<Integer> pool=new ObjectPoolHelper<Integer>(new ObjectFactory<Integer>(){
    @Override public Integer create(){
      return 3;
    }
  }
);
  final GenericObjectPool<Integer> mockObjectPool=Mockito.mock(GenericObjectPool.class);
  pool.setObjectPool(mockObjectPool);
  pool.getObject();
  Mockito.verify(mockObjectPool,Mockito.times(1)).borrowObject();
}
