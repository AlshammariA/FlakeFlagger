@Test public void toString_with_anonymous_comparator(){
  ComparatorBasedComparisonStrategy lengthComparisonStrategy=new ComparatorBasedComparisonStrategy(new Comparator<String>(){
    @Override public int compare(    String s1,    String s2){
      return s1.length() - s2.length();
    }
  }
);
  assertEquals("'anonymous comparator class'",lengthComparisonStrategy.toString());
}
