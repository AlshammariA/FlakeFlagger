@Test public void closeContextAndParent(){
  ConfigurableApplicationContext mock=mock(ConfigurableApplicationContext.class);
  ConfigurableApplicationContext parent=mock(ConfigurableApplicationContext.class);
  given(mock.getParent()).willReturn(parent);
  given(parent.getParent()).willReturn(null);
  ApplicationContextTestUtils.closeAll(mock);
  verify(mock).getParent();
  verify(mock).close();
  verify(parent).getParent();
  verify(parent).close();
}
