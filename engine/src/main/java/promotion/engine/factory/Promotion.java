package promotion.engine.factory;

/**
 * This class properties and behaviour of promotion type in the system
 * */
public abstract class Promotion {
	public abstract void setPromotionDetail();
	public abstract double getPrice(Promotion promotion);
}
