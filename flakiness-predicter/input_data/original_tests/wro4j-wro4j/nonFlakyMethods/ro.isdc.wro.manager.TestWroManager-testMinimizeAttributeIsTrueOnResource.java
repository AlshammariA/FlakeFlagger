@Test public void testMinimizeAttributeIsTrueOnResource() throws Exception {
  new GenericTestBuilder().processAndCompare("/resourceMinimizeTrue.js","classpath:ro/isdc/wro/manager/sample.min.js");
}
