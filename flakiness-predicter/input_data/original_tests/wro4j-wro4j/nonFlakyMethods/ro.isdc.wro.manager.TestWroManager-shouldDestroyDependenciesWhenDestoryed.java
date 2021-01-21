@Test public void shouldDestroyDependenciesWhenDestoryed(){
  final WroManager manager=new WroManager.Builder().setCacheStrategy(mockCacheStrategy).setModelFactory(mockModelFactory).build();
  manager.destroy();
  verify(mockCacheStrategy).destroy();
  verify(mockModelFactory).destroy();
}
