@Test public void should_pass_if_actual_has_same_size_as_other_whatever_custom_comparison_strategy_is(){
  iterablesWithCaseInsensitiveComparisonStrategy.assertHasSameSizeAs(someInfo(),newArrayList("Luke","Yoda"),newArrayList("Solo","Leia"));
}
