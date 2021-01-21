@Test public void testIsEnabledByDefault(){
  assertEquals(false,FeatureAnnotations.isEnabledByDefault(MyFeature.FEATURE_WITH_LABEL));
  assertEquals(false,FeatureAnnotations.isEnabledByDefault(MyFeature.FEATURE_WITHOUT_LABEL));
  assertEquals(true,FeatureAnnotations.isEnabledByDefault(MyFeature.FEATURE_ENABLED_BY_DEFAULT));
}
