@Test public void should_extract_single_value_from_maps_by_key(){
  String key1="key1";
  String key2="key2";
  Map<String,Employee> map1=new HashMap<>();
  map1.put(key1,yoda);
  Employee luke=new Employee(2L,new Name("Luke"),22);
  map1.put(key2,luke);
  Map<String,Employee> map2=new HashMap<>();
  map2.put(key1,yoda);
  Employee han=new Employee(3L,new Name("Han"),31);
  map2.put(key2,han);
  List<Map<String,Employee>> maps=asList(map1,map2);
  assertThat(maps).extracting(key2).containsExactly(luke,han);
  assertThat(maps).extracting(key2,Employee.class).containsExactly(luke,han);
  assertThat(maps).extracting(key1).containsExactly(yoda,yoda);
  assertThat(maps).extracting("bad key").containsExactly(null,null);
}
