@Test public void testgetClassNameViaImplicitRules(){
  Class<?> compClass=setter.getClassNameViaImplicitRules("door",AggregationType.AS_COMPLEX_PROPERTY,defaultComponentRegistry);
  assertEquals(Door.class,compClass);
}
