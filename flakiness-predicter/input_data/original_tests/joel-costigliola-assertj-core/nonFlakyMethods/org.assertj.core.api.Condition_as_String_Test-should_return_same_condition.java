@Test public void should_return_same_condition(){
  Condition<Object> returnedCondition=condition.as(someTextDescription());
  assertSame(condition,returnedCondition);
}
