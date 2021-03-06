/*
 * Copyright (c) 2003, 2019, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package jdk.javadoc.internal.doclets.formats.html;


import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;

import jdk.javadoc.internal.doclets.formats.html.markup.ContentBuilder;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlTree;
import jdk.javadoc.internal.doclets.formats.html.markup.StringContent;
import jdk.javadoc.internal.doclets.formats.html.markup.Table;
import jdk.javadoc.internal.doclets.formats.html.markup.TableHeader;
import jdk.javadoc.internal.doclets.toolkit.Content;
import jdk.javadoc.internal.doclets.toolkit.EnumConstantWriter;
import jdk.javadoc.internal.doclets.toolkit.MemberSummaryWriter;

/**
 * Writes enum constant documentation in HTML format.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class EnumConstantWriterImpl extends AbstractMemberWriter
    implements EnumConstantWriter, MemberSummaryWriter {

    public EnumConstantWriterImpl(SubWriterHolderWriter writer, TypeElement typeElement) {
        super(writer, typeElement);
    }

    public EnumConstantWriterImpl(SubWriterHolderWriter writer) {
        super(writer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Content getMemberSummaryHeader(TypeElement typeElement,
            Content memberSummaryTree) {
        memberSummaryTree.add(MarkerComments.START_OF_ENUM_CONSTANT_SUMMARY);
        Content memberTree = new ContentBuilder();
        writer.addSummaryHeader(this, typeElement, memberTree);
        return memberTree;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addMemberTree(Content memberSummaryTree, Content memberTree) {
        writer.addMemberTree(HtmlStyle.constantsSummary, memberSummaryTree, memberTree);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Content getEnumConstantsDetailsTreeHeader(TypeElement typeElement,
            Content memberDetailsTree) {
        memberDetailsTree.add(MarkerComments.START_OF_ENUM_CONSTANT_DETAILS);
        Content enumConstantsDetailsTree = new ContentBuilder();
        Content heading = HtmlTree.HEADING(Headings.TypeDeclaration.DETAILS_HEADING,
                contents.enumConstantDetailLabel);
        enumConstantsDetailsTree.add(links.createAnchor(
                SectionName.ENUM_CONSTANT_DETAIL));
        enumConstantsDetailsTree.add(heading);
        return enumConstantsDetailsTree;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Content getEnumConstantsTreeHeader(VariableElement enumConstant,
            Content enumConstantsDetailsTree) {
        Content enumConstantsTree = new ContentBuilder();
        Content heading = new HtmlTree(Headings.TypeDeclaration.MEMBER_HEADING);
        heading.add(links.createAnchor(name(enumConstant), new StringContent(name(enumConstant))));
        enumConstantsTree.add(heading);
        return HtmlTree.SECTION(HtmlStyle.detail, enumConstantsTree);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Content getSignature(VariableElement enumConstant) {
        return new MemberSignature(enumConstant)
                .addType(enumConstant.asType())
                .toContent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addDeprecated(VariableElement enumConstant, Content enumConstantsTree) {
        addDeprecatedInfo(enumConstant, enumConstantsTree);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addComments(VariableElement enumConstant, Content enumConstantsTree) {
        addComment(enumConstant, enumConstantsTree);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addTags(VariableElement enumConstant, Content enumConstantsTree) {
        writer.addTagsInfo(enumConstant, enumConstantsTree);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Content getEnumConstantsDetails(Content enumConstantsDetailsTreeHeader,
            Content enumConstantsDetailsTree) {
        Content enumConstantsDetails =
                new ContentBuilder(enumConstantsDetailsTreeHeader, enumConstantsDetailsTree);
        return getMemberTree(HtmlTree.SECTION(HtmlStyle.constantDetails, enumConstantsDetails));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Content getEnumConstants(Content enumConstantsTree) {
        return getMemberTree(enumConstantsTree);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addSummaryLabel(Content memberTree) {
        Content label = HtmlTree.HEADING(Headings.TypeDeclaration.SUMMARY_HEADING,
                contents.enumConstantSummary);
        memberTree.add(label);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TableHeader getSummaryTableHeader(Element member) {
        return new TableHeader(contents.enumConstantLabel, contents.descriptionLabel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Table createSummaryTable() {
        return new Table(HtmlStyle.memberSummary)
                .setCaption(contents.getContent("doclet.Enum_Constants"))
                .setHeader(getSummaryTableHeader(typeElement))
                .setColumnStyles(HtmlStyle.colFirst, HtmlStyle.colLast);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addSummaryAnchor(TypeElement typeElement, Content memberTree) {
        memberTree.add(links.createAnchor(SectionName.ENUM_CONSTANT_SUMMARY));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addInheritedSummaryAnchor(TypeElement typeElement, Content inheritedTree) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addInheritedSummaryLabel(TypeElement typeElement, Content inheritedTree) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addSummaryLink(LinkInfoImpl.Kind context, TypeElement typeElement, Element member,
            Content tdSummary) {
        Content memberLink = HtmlTree.SPAN(HtmlStyle.memberNameLink,
                writer.getDocLink(context, member, name(member), false));
        Content code = HtmlTree.CODE(memberLink);
        tdSummary.add(code);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addInheritedSummaryLink(TypeElement typeElement, Element member, Content linksTree) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addSummaryType(Element member, Content tdSummaryType) {
        //Not applicable.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Content getDeprecatedLink(Element member) {
        String name = utils.getFullyQualifiedName(member) + "." + member.getSimpleName();
        return writer.getDocLink(LinkInfoImpl.Kind.MEMBER, member, name);
    }

    @Override
    public Content getMemberTreeHeader(){
        return writer.getMemberTreeHeader();
    }
}
