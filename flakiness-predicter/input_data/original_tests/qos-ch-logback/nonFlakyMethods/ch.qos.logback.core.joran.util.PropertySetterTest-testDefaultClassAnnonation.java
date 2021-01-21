@Test public void testDefaultClassAnnonation(){
  Method relevantMethod=setter.getRelevantMethod("SwimmingPool",AggregationType.AS_COMPLEX_PROPERTY);
  assertNotNull(relevantMethod);
  Class<?> spClass=setter.getDefaultClassNameByAnnonation("SwimmingPool",relevantMethod);
  assertEquals(SwimmingPoolImpl.class,spClass);
  Class<?> classViaImplicitRules=setter.getClassNameViaImplicitRules("SwimmingPool",AggregationType.AS_COMPLEX_PROPERTY,defaultComponentRegistry);
  assertEquals(SwimmingPoolImpl.class,classViaImplicitRules);
}
