@Test public void testDefaultClassAnnotationForLists(){
  Method relevantMethod=setter.getRelevantMethod("LargeSwimmingPool",AggregationType.AS_COMPLEX_PROPERTY_COLLECTION);
  assertNotNull(relevantMethod);
  Class<?> spClass=setter.getDefaultClassNameByAnnonation("LargeSwimmingPool",relevantMethod);
  assertEquals(LargeSwimmingPoolImpl.class,spClass);
  Class<?> classViaImplicitRules=setter.getClassNameViaImplicitRules("LargeSwimmingPool",AggregationType.AS_COMPLEX_PROPERTY_COLLECTION,defaultComponentRegistry);
  assertEquals(LargeSwimmingPoolImpl.class,classViaImplicitRules);
}
