@Test public void testLastValidIsOK(){
  Assert.assertNotNull(fallbackAwareModelFactory.create());
  fallbackAwareModelFactory.destroy();
  Assert.assertNotNull(fallbackAwareModelFactory.create());
}
