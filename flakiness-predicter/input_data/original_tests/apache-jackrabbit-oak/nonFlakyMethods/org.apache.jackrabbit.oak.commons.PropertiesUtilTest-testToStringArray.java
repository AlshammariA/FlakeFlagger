@Test public void testToStringArray(){
  final String[] defaultValue=new String[]{"1"};
  assertArrayEquals(null,PropertiesUtil.toStringArray(5));
  assertArrayEquals(null,PropertiesUtil.toStringArray(null));
  assertArrayEquals(defaultValue,PropertiesUtil.toStringArray(5,defaultValue));
  assertArrayEquals(defaultValue,PropertiesUtil.toStringArray(null,defaultValue));
  assertArrayEquals(new String[]{"hallo"},PropertiesUtil.toStringArray("hallo",defaultValue));
  assertArrayEquals(new String[]{"hallo"},PropertiesUtil.toStringArray(new String[]{"hallo"},defaultValue));
  assertArrayEquals(new String[]{"hallo","you"},PropertiesUtil.toStringArray(new String[]{"hallo","you"},defaultValue));
  assertArrayEquals(new String[]{"5","1"},PropertiesUtil.toStringArray(new Integer[]{5,1},defaultValue));
  assertArrayEquals(new String[]{"5","1"},PropertiesUtil.toStringArray(new Integer[]{5,null,1},defaultValue));
  final List<String> l=new ArrayList<String>();
  assertArrayEquals(new String[]{},PropertiesUtil.toStringArray(l,defaultValue));
  l.add("1");
  l.add("2");
  assertArrayEquals(new String[]{"1","2"},PropertiesUtil.toStringArray(l,defaultValue));
  l.add(null);
  assertArrayEquals(new String[]{"1","2"},PropertiesUtil.toStringArray(l,defaultValue));
  final Map<String,Object> m=new HashMap<String,Object>();
  m.put("1",5);
  assertArrayEquals(defaultValue,PropertiesUtil.toStringArray(m,defaultValue));
}
