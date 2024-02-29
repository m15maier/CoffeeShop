package ee.coffee.coffeeshop.entity;

public class EntityUtil
{
	public static final Long NEW_ENTITY_ID = 0L;
	
	public static boolean isNew(Long id) {
		return id == null || id.longValue() == NEW_ENTITY_ID;
	}
	
	
	public static boolean isNew(Product product) {
		return isNew(product.getId());
	}

}
