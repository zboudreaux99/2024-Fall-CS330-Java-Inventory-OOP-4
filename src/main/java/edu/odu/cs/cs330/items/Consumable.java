package edu.odu.cs.cs330.items;

/**
 * This class represents one Consumable Item--as found in most video games.
 * This includes food.
 *
 * Consumable Items must be stackable.
 */
@SuppressWarnings({
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal",
    "PMD.BeanMembersShouldSerialize"
})
public class Consumable implements Item {
    /**
     * Format used to generate a printable representation.
     */
    public static final String FMT_STR = String.join(
        "",
        "  Nme: %s%n",
        "  Eft: %s%n",
        "  Use: %d%n"
    );

    /**
     * The name...
     */
    protected String name;

    /**
     * The effect "buff" or "debuff" that is received when using this item.
     */
    protected String effect;

    /**
     * The number of times this item can be used.
     */
    protected int uses;

    /**
     * Default to a Consumable Item with an empty name, no effect and zero
     * uses.
     */
    public Consumable()
    {
        super();
        this.setEffect("");
        this.setNumberOfUses(0);
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public void setName(final String nme)
    {
        this.name = nme;
    }

    /**
     * Retrieve the effect.
     *
     * @return the set effect (i.e., buff or debuff)
     */
    public String getEffect()
    {
        return this.effect;
    }

    /**
     * Set a new buff or debuff.
     *
     * @param newEff replacement effect
     */
    public void setEffect(String newEff)
    {
        this.effect = newEff;
    }

    /**
     * Retrieve permitted number of uses.
     *
     * @return number of total uses
     */
    public int getNumberOfUses()
    {
        return this.uses;
    }

    /**
     * Set the number of permitted uses.
     *
     * @param allowed number of allowed uses
     */
    public void setNumberOfUses(int allowed)
    {
        this.uses = allowed;
    }

    @Override
    public boolean isStackable()
    {
        return true;
    }

    /**
     * Clone--i.e., copy--this Consumable Item.
     */
    @Override
    public Item clone()
    {
        Consumable clone = new Consumable();
        clone.setName(this.getName());
        clone.setEffect(this.getEffect());
        clone.setNumberOfUses(this.getNumberOfUses());
        return clone;
    }

    /**
     * Check for logical equivalence--based on name and effect.
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof Consumable)) {
            return false;
        } else if (this == rhs) {
            return true;
        }

        Consumable rhsItem = (Consumable) rhs;

        return this.getName().equals(rhsItem.getName()) &&
               this.getEffect().equals(rhsItem.getEffect());
    }

    /**
     * Generate a hash code based on name and effect.
     *
     * Add <code>name.hashCode()</code> and <code>effect.hashCode</code>, then
     * return the result.
     */
    @Override
    public int hashCode()
    {
        return this.getName().hashCode() + this.getEffect().hashCode();
    }

    /**
     * *Print* the Consumable Item.
     */
    @Override
    public String toString()
    {
        System.out.println(String.format(FMT_STR, this.getName(), this.getEffect(), this.getNumberOfUses()));
        return String.format(FMT_STR, this.getName(), this.getEffect(), this.getNumberOfUses());
    }
}
