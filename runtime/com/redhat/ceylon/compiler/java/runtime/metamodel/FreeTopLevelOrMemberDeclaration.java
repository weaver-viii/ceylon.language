package com.redhat.ceylon.compiler.java.runtime.metamodel;

import ceylon.language.Sequential;
import ceylon.language.model.Annotated$impl;
import ceylon.language.model.declaration.Package;
import ceylon.language.model.declaration.TopLevelOrMemberDeclaration$impl;
import ceylon.language.model.declaration.Declaration$impl;
import ceylon.language.model.declaration.TypedDeclaration$impl;
import ceylon.language.model.declaration.AnnotatedDeclaration$impl;

import com.redhat.ceylon.compiler.java.metadata.Ceylon;
import com.redhat.ceylon.compiler.java.metadata.Ignore;
import com.redhat.ceylon.compiler.java.metadata.TypeInfo;
import com.redhat.ceylon.compiler.java.metadata.TypeParameter;
import com.redhat.ceylon.compiler.java.metadata.TypeParameters;
import com.redhat.ceylon.compiler.java.runtime.model.ReifiedType;
import com.redhat.ceylon.compiler.java.runtime.model.TypeDescriptor;
import com.redhat.ceylon.compiler.typechecker.model.Scope;
import com.redhat.ceylon.compiler.typechecker.model.TypeDeclaration;

@Ceylon(major = 5)
@com.redhat.ceylon.compiler.java.metadata.Class
public abstract class FreeTopLevelOrMemberDeclaration 
    implements ceylon.language.model.declaration.TopLevelOrMemberDeclaration, ReifiedType {
    
    @Ignore
    public static final TypeDescriptor $TypeDescriptor = TypeDescriptor.klass(FreeTopLevelOrMemberDeclaration.class);

    @Ignore
    protected com.redhat.ceylon.compiler.typechecker.model.Declaration declaration;
    
    private Package pkg;

    @Override
    public String toString() {
        String string = declaration.getName();
        Scope container = declaration.getContainer();
        while (container instanceof TypeDeclaration) {
            string = ((TypeDeclaration) container).getName() + '.' + string;
            container = container.getContainer();
        }
        return string;
    }

    public FreeTopLevelOrMemberDeclaration(com.redhat.ceylon.compiler.typechecker.model.Declaration declaration) {
        this.declaration = declaration;
    }

    @Override
    @Ignore
    public TopLevelOrMemberDeclaration$impl $ceylon$language$model$declaration$TopLevelOrMemberDeclaration$impl() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Ignore
    public Declaration$impl $ceylon$language$model$declaration$Declaration$impl() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Ignore
    public TypedDeclaration$impl $ceylon$language$model$declaration$TypedDeclaration$impl() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Ignore
    public AnnotatedDeclaration$impl $ceylon$language$model$declaration$AnnotatedDeclaration$impl() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Ignore
    public Annotated$impl $ceylon$language$model$Annotated$impl() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getName() {
        return declaration.getName();
    }

    @Override
    public Package getPackageContainer() {
        // this does not need to be thread-safe as Metamodel.getOrCreateMetamodel is thread-safe so if we
        // assign pkg twice we get the same result
        if(pkg == null){
            pkg = Metamodel.getOrCreateMetamodel(Metamodel.getPackage(declaration));
        }
        return pkg;
    }

    @Override
    public boolean getToplevel() {
        return declaration.isToplevel();
    }

    @Override
    public boolean getActual() {
        return declaration.isActual();
    }

    @Override
    public boolean getFormal() {
        return declaration.isFormal();
    }

    @Override
    public boolean getDefault() {
        return declaration.isDefault();
    }

    @Override
    public boolean getShared() {
        return declaration.isShared();
    }

    @Override
    public ceylon.language.model.declaration.AnnotatedDeclaration getContainer() {
        Scope container = declaration.getContainer();
        if(container instanceof com.redhat.ceylon.compiler.typechecker.model.Declaration)
            return Metamodel.getOrCreateMetamodel((com.redhat.ceylon.compiler.typechecker.model.Declaration)container);
        if(container instanceof com.redhat.ceylon.compiler.typechecker.model.Package)
            return Metamodel.getOrCreateMetamodel((com.redhat.ceylon.compiler.typechecker.model.Package)container);
        // FIXME: can that happen?
        throw new RuntimeException("Illegal container type: "+container);
    }

    @Override
    @TypeInfo("ceylon.language::Sequential<Annotation>")
    @TypeParameters(@TypeParameter(value = "Annotation", satisfies = "ceylon.language.model::Annotation<Annotation>"))
    public <Annotation extends ceylon.language.model.Annotation<? extends Annotation>> Sequential<? extends Annotation> annotations(@Ignore TypeDescriptor $reifiedAnnotation) {
        return Metamodel.annotations($reifiedAnnotation, this);
    }

    @Ignore
    @Override
    public TypeDescriptor $getType() {
        return $TypeDescriptor;
    }
}
