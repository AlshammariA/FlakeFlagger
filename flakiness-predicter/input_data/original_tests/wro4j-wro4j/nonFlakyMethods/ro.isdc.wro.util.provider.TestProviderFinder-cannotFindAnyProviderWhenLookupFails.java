@Test(expected=WroRuntimeException.class) public void cannotFindAnyProviderWhenLookupFails(){
  victim=new ProviderFinder<ProcessorProvider>(ProcessorProvider.class){
    @Override <F>Iterator<F> lookupProviders(    final Class<F> clazz){
      throw new IllegalStateException("BOOM!");
    }
  }
;
  victim.find();
}
