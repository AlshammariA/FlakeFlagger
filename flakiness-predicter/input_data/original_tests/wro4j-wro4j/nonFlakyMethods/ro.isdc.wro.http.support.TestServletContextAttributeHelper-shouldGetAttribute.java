@Test public void shouldGetAttribute(){
  final Attribute attr=Attribute.CONFIGURATION;
  final WroConfiguration value=new WroConfiguration();
  Mockito.when(mockServletContext.getAttribute(victim.getAttributeName(attr))).thenReturn(value);
  Assert.assertSame(value,victim.getAttribute(attr));
}
