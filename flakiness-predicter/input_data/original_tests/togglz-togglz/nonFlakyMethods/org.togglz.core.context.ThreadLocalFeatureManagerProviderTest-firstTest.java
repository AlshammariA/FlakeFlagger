/** 
 * The first test requires a FeatureManager
 */
@Test public void firstTest(){
  FeatureManager featureManager=FeatureContext.getFeatureManager();
  assertNotNull(featureManager);
}
