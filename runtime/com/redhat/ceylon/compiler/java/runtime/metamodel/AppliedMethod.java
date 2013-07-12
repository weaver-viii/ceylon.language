package com.redhat.ceylon.compiler.java.runtime.metamodel;

import ceylon.language.Sequential;
import ceylon.language.metamodel.DeclarationType$impl;
import ceylon.language.metamodel.Function;
import ceylon.language.metamodel.FunctionType$impl;
import ceylon.language.metamodel.Method$impl;
import ceylon.language.metamodel.declaration.FunctionDeclaration;

import com.redhat.ceylon.compiler.java.metadata.Ceylon;
import com.redhat.ceylon.compiler.java.metadata.Ignore;
import com.redhat.ceylon.compiler.java.metadata.TypeInfo;
import com.redhat.ceylon.compiler.java.metadata.TypeParameter;
import com.redhat.ceylon.compiler.java.metadata.TypeParameters;
import com.redhat.ceylon.compiler.java.metadata.Variance;
import com.redhat.ceylon.compiler.java.runtime.model.TypeDescriptor;
import com.redhat.ceylon.compiler.typechecker.model.ProducedReference;

@Ceylon(major = 5)
@com.redhat.ceylon.compiler.java.metadata.Class
@TypeParameters({
    @TypeParameter(value = "Container", variance = Variance.IN),
    @TypeParameter(value = "Type", variance = Variance.OUT),
    @TypeParameter(value = "Arguments", variance = Variance.IN, satisfies = "ceylon.language::Sequential<ceylon.language::Anything>"),
})
public class AppliedMethod<Container, Type, Arguments extends Sequential<? extends Object>> 
    extends AppliedMember<Container, ceylon.language.metamodel.Function<? extends Type, ? super Arguments>> 
    implements ceylon.language.metamodel.Method<Container, Type, Arguments> {

    private FreeFunction declaration;
    private ProducedReference appliedFunction;
    private ceylon.language.metamodel.Type closedType;
    @Ignore
    private TypeDescriptor $reifiedType;
    @Ignore
    private TypeDescriptor $reifiedArguments;

    public AppliedMethod(@Ignore TypeDescriptor $reifiedContainer, 
                         @Ignore TypeDescriptor $reifiedType, 
                         @Ignore TypeDescriptor $reifiedArguments, 
                         ProducedReference appliedFunction, 
                         FreeFunction declaration) {
        super($reifiedType, TypeDescriptor.klass(ceylon.language.metamodel.Function.class, $reifiedType, $reifiedArguments));
        this.$reifiedType = $reifiedType;
        this.$reifiedArguments = $reifiedArguments;
        this.appliedFunction = appliedFunction;
        this.declaration = declaration;
        // FIXME: check MPL
        this.closedType = Metamodel.getAppliedMetamodel(appliedFunction.getType());
    }

    @Override
    @Ignore
    public DeclarationType$impl $ceylon$language$metamodel$DeclarationType$impl() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Ignore
    public Method$impl<Container, Type, Arguments> $ceylon$language$metamodel$Method$impl() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Ignore
    public FunctionType$impl<Type, Arguments> $ceylon$language$metamodel$FunctionType$impl() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @TypeInfo("ceylon.language.metamodel.declaration::FunctionDeclaration")
    public FunctionDeclaration getDeclaration() {
        return declaration;
    }

    @Override
    @TypeInfo("ceylon.language.metamodel::Type")
    public ceylon.language.metamodel.Type getType() {
        return closedType;
    }

    @Override
    protected Function<Type, Arguments> bindTo(Object instance) {
        return new AppliedFunction<>($reifiedType, $reifiedArguments, appliedFunction, declaration, instance);
    }

    @Override
    public TypeDescriptor $getType() {
        return TypeDescriptor.klass(AppliedMethod.class, super.$reifiedType, $reifiedType, $reifiedArguments);
    }
}
