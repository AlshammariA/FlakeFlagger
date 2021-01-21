@Test public void shouldDestroyDestroyableProcessorWhenManagerIsDestroyed(){
  final DestroyableProcessor preProcessor=Mockito.mock(DestroyableProcessor.class);
  final DestroyableProcessor postProcessor=Mockito.mock(DestroyableProcessor.class);
  victim=new BaseWroManagerFactory().setProcessorsFactory(new SimpleProcessorsFactory().addPreProcessor(preProcessor).addPostProcessor(postProcessor)).create();
  victim.destroy();
  Mockito.verify(preProcessor,Mockito.times(1)).destroy();
  Mockito.verify(postProcessor,Mockito.times(1)).destroy();
}
