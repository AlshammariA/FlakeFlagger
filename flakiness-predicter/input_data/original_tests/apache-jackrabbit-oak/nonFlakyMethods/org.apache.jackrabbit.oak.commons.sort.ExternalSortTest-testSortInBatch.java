@Test public void testSortInBatch() throws Exception {
  Comparator<String> cmp=new Comparator<String>(){
    @Override public int compare(    String o1,    String o2){
      return o1.compareTo(o2);
    }
  }
;
  List<File> listOfFiles=ExternalSort.sortInBatch(this.csvFile,cmp,ExternalSort.DEFAULTMAXTEMPFILES,ExternalSort.DEFAULT_MAX_MEM_BYTES,Charset.defaultCharset(),null,false,1,false);
  assertEquals(1,listOfFiles.size());
  ArrayList<String> result=readLines(listOfFiles.get(0));
  assertArrayEquals(Arrays.toString(result.toArray()),EXPECTED_MERGE_DISTINCT_RESULTS,result.toArray());
}
