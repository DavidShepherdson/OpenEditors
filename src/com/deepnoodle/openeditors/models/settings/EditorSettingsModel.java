
package com.deepnoodle.openeditors.models.settings;

import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorReference;

import com.deepnoodle.openeditors.models.editor.IEditor;

//TODO change name, it's not just settings
public class EditorSettingsModel implements IEditor
{
    private String filePath;
    private boolean pinned;
    private Integer naturalPosition;
    private boolean opened = false;
    private String titleImagePath;
    private String cachedName;
    private String cachedPartName;

    // These are not saved
    private transient boolean dirty = false;
    private transient Integer historyPosition = Integer.MAX_VALUE;
    private transient IEditorReference reference;
    private transient Image titleImage;

    @Override
    public Image getTitleImage()
    {
        return titleImage;
    }

    @Override
    public void setTitleImage(Image titleImage)
    {
        this.titleImage = titleImage;
    }

    public void setDirty(boolean dirty)
    {
        this.dirty = dirty;
    }

    public EditorSettingsModel(String filePath)
    {
        this.filePath = filePath;
    }

    @Override
    public String getFilePath()
    {
        return filePath;
    }

    @Override
    public void setFilePath(String path)
    {
        filePath = path;
    }

    @Override
    public String getName()
    {
        return reference == null ? cachedName : reference.getName();
    }

    @Override
    public String getDisplayName()
    {
        return (isDirty() ? "*" : "")
                + (reference == null ? cachedPartName : reference.getPartName());
    }

    @Override
    public boolean isPinned()
    {
        return pinned;
    }

    @Override
    public void setPinned(boolean pinned)
    {
        this.pinned = pinned;
    }

    @Override
    public Integer getNaturalPosition()
    {
        return naturalPosition;
    }

    @Override
    public void setNaturalPosition(Integer naturalPosition)
    {
        this.naturalPosition = naturalPosition;
    }

    @Override
    public boolean isOpened()
    {
        return opened;
    }

    @Override
    public void setOpened(boolean opened)
    {
        this.opened = opened;
    }

    @Override
    public Integer getHistoryPosition()
    {
        return historyPosition;
    }

    @Override
    public void setHistoryPosition(Integer historyPosition)
    {
        this.historyPosition = historyPosition;
    }

    @Override
    public boolean isDirty()
    {
        return dirty;
    }

    @Override
    public IEditorReference getReference()
    {
        return reference;
    }

    @Override
    public void setReference(IEditorReference reference)
    {
        this.reference = reference;
        if (reference != null)
        {
            this.cachedName = reference.getName();
            this.cachedPartName = reference.getPartName();
        }
    }

    @Override
    public String getTitleImagePath()
    {
        return titleImagePath;
    }

    @Override
    public void setTitleImagePath(String titleImagePath)
    {
        this.titleImagePath = titleImagePath;
    }

    @Override
    public String toString()
    {
        return getDisplayName();
    }
}
