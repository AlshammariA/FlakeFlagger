@Test public void should_succeed_since_actual_is_zero(){
  floats.assertIsNotPositive(someInfo(),0f);
}
