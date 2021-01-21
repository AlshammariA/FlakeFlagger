@Test public void shouldNotFindProviderWhenNoneIsAvailable(){
  victim=new ProviderFinder<ProcessorProvider>(ProcessorProvider.class){
    @Override <F>Iterator<F> lookupProviders(    final Class<F> clazz){
      return new ArrayList<F>().iterator();
    }
  }
;
  assertTrue(victim.find().isEmpty());
}
