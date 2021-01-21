@Test public void shouldCleanupProperlyWhenDestroyed(){
  PreProcessorExecutor mockPreProcessorExecutor=mock(PreProcessorExecutor.class);
  victim.setPreProcessorExecutor(mockPreProcessorExecutor);
  victim.destroy();
  verify(mockPreProcessorExecutor).destroy();
}
