@Test public void shouldBeDestroyableProcessorWhenDecoratingDestroyable() throws Exception {
  final DestroyableProcessor originalProcessor=Mockito.spy(new DestroyableProcessor());
  final ProcessorDecorator decorated=new ProcessorDecorator(originalProcessor);
  decorated.destroy();
  Mockito.verify(originalProcessor).destroy();
}
