@Test public void should_succeed_since_actual_is_positive(){
  doubles.assertIsPositive(someInfo(),(double)6);
}
