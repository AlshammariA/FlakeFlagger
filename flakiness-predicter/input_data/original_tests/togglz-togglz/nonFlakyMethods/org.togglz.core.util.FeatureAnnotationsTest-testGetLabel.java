@Test public void testGetLabel(){
  assertEquals("Some feature with a label",FeatureAnnotations.getLabel(MyFeature.FEATURE_WITH_LABEL));
  assertEquals("FEATURE_WITHOUT_LABEL",FeatureAnnotations.getLabel(MyFeature.FEATURE_WITHOUT_LABEL));
}
