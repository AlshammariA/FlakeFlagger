@Test public void should_pass_if_condition_is_not_null(){
  conditions.assertIsNotNull(new TestCondition<String>());
}
