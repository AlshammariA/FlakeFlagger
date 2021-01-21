@Test public void verify_that_isGreaterThan_delegates_to_compare_method(){
  caseInsensitiveStringComparator=mock(CaseInsensitiveStringComparator.class);
  caseInsensitiveComparisonStrategy=new ComparatorBasedComparisonStrategy(caseInsensitiveStringComparator);
  String s1="string1";
  String s2="string2";
  caseInsensitiveComparisonStrategy.isGreaterThan(s1,s2);
  verify(caseInsensitiveStringComparator).compare(s1,s2);
}
