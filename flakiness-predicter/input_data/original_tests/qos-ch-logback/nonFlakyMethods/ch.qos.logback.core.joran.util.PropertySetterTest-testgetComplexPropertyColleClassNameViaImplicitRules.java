@Test public void testgetComplexPropertyColleClassNameViaImplicitRules(){
  Class<?> compClass=setter.getClassNameViaImplicitRules("window",AggregationType.AS_COMPLEX_PROPERTY_COLLECTION,defaultComponentRegistry);
  assertEquals(Window.class,compClass);
}
